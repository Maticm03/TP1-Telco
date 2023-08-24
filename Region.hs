module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
   where

import Point 
import City 
import Quality 
import Link 
import Tunel 

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR ciudad link tunel = Reg ciudad link tunel

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunnels) newCity = Reg (newCity : cities) links tunnels
 

-- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR :: Region -> City -> City -> Quality -> Region
linkR (Reg cities links tunnels) city1 city2 quality =
    let newLink = newL city1 city2 quality
        newLinks = newLink : links
    in Reg cities newLinks tunnels

-- genera una comunicación entre dos ciudades distintas de la región
tunelR :: Region -> [City] -> Region
tunelR region@(Reg cities links tunnels) [ciudadA, ciudadB]
    | ciudadA /= ciudadB && ciudadA `elem` cities && ciudadB `elem` cities =
        let newTunnel = newT [newL ciudadA ciudadB]
           newTunnels = newTunnel : tunnels
       in Reg cities links newTunnels
    | otherwise = region
tunelR region _ = region

-- indica si estas dos ciudades estan conectadas por un tunel
connectedR :: Region -> City -> City -> Bool
connectedR (Reg _ _ tunnels) ciudadA ciudadB =
    any (connectsT ciudadA ciudadB) tunnels

-- indica si estas dos ciudades estan enlazadas
linkedR :: Region -> City -> City -> Bool
linkedR (Reg _ links _) ciudadA ciudadB =
    any (\enlace -> connectsL ciudadA enlace || connectsL ciudadB enlace) links

-- dadas dos ciudades conectadas, indica la demora
delayR :: Region -> City -> City -> Float
delayR (Reg _ links tunnels) ciudadA ciudadB =
    case findTunnelWithLinks tunnels of
        Just tunnelLinks -> calculateTotalDelay tunnelLinks
        Nothing -> 0.0
  where
    findTunnelWithLinks (tunnelLinks : rest)
        | connectsT ciudadA ciudadB tunnelLinks = Just tunnelLinks
        | otherwise = findTunnelWithLinks rest
    findTunnelWithLinks [] = Nothing

    calculateTotalDelay enlaces = sum (map delayL enlaces)

-- indica la capacidad disponible entre dos ciudades
availableCapacityForR :: Region -> City -> City -> Int
availableCapacityForR (Reg _ links _) ciudadA ciudadB =
    case findLink links of
        Just link -> capacityL link
        Nothing -> 0
  where
    findLink (link : rest)
        | linksL ciudadA ciudadB link || linksL ciudadB ciudadA link = Just link
        | otherwise = findLink rest
    findLink [] = Nothing
