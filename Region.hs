module Region ( Region, newR, foundR, linkR, connectedR, linkedR, delayR, availableCapacityForR)-- tunelR
   where

import Point 
import City 
import Quality 
import Link 
import Tunel 


data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunnels) newCity = Reg (newCity : cities) links tunnels

-- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR :: Region -> City -> City -> Quality -> Region
linkR (Reg cities links tunnels) city1 city2 quality =
    let newLink = newL city1 city2 quality
        newLinks = newLink : links
    in Reg cities newLinks tunnels

-- genera una comunicación entre dos ciudades distintas de la región



instance Show Region where
    show (Reg cities links tunnels) =
        "Cities: " ++ show cities ++ "\n" ++
        "Links: " ++ show links ++ "\n" ++
        "Tunnels: " ++ show tunnels

-- indica si estas dos ciudades estan conectadas por un tunel
connectedR :: Region -> City -> City -> Bool
connectedR (Reg _ _ tunnels) cityA cityB =
    any (\tunnel -> connectsT cityA cityB tunnel) tunnels

-- indica si estas dos ciudades estan enlazadas
linkedR :: Region -> City -> City -> Bool
linkedR (Reg _ links _) ciudadA ciudadB =
    any (\enlace -> connectsL ciudadA enlace || connectsL ciudadB enlace) links

-- dadas dos ciudades conectadas, indica la demora
delayR :: Region -> City -> City -> Float
delayR (Reg _ _ tunnels) cityA cityB =
    case findTunnel tunnels of
        Just tunnel -> delayT tunnel
        Nothing -> 0.0
  where
    findTunnel (tunnel : rest)
        | connectsT cityA cityB tunnel || connectsT cityB cityA tunnel = Just tunnel
        | otherwise = findTunnel rest
    findTunnel [] = Nothing

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
