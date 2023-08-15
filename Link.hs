module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

import Point
import City 
import Quality

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL ciudad1 ciudad2 quality = Lin ciudad1 ciudad2 quality

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL ciudad (Lin ciudad1 ciudad2 _) = ciudad == ciudad1 || ciudad == ciudad2

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL ciudadA ciudadB (Lin ciudad1 ciudad2 _) = ciudadA == ciudad1 && ciudadB == ciudad2 
                                                || ciudadA == ciudad2 && ciudadB == ciudad1

capacityL :: Link -> Int
capacityL (Lin _ _ quality) = capacityQ quality

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin _ _ quality) = delayQ quality
