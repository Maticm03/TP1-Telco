module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
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

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región


connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel


linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas


delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora


availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades

