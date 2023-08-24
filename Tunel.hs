module Tunel ( Tunel, newT, usesT, delayT, connectsT)
   where

import Point
import City  
import Quality
import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT enlaces = Tun enlaces

connectsT :: City -> City -> Tunel -> Bool
connectsT ciudadA ciudadB (Tunel enlaces) =
    case enlaces of
        [] -> False
        [enlace] -> isExtremo ciudadA enlace || isExtremo ciudadB enlace
        _ -> let primerEnlace = head enlaces
                 ultimoEnlace = last enlaces
             in (isExtremo ciudadA primerEnlace || isExtremo ciudadB primerEnlace)
                && (isExtremo ciudadA ultimoEnlace || isExtremo ciudadB ultimoEnlace)

isExtremo :: City -> (City, City, Quality) -> Bool
isExtremo ciudad (ciudad1, ciudad2, _) = ciudad == ciudad1 || ciudad == ciudad2

usesT :: Link -> Tunel -> Bool -- indica si este tunel atraviesa ese link
usesT enlace (Tun enlaces) = enlace `elem` enlaces

-- la demora que sufre una conexion en este tunel
delayT :: Tunel -> Float
delayT (Tun enlaces) = sum $ map delayL enlaces
