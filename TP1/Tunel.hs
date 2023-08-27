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
connectsT cityA cityB (Tun enlaces) =
    case enlaces of
        [] -> False
        [enlace] -> connectsL cityA enlace && connectsL cityB enlace
        firstEnlace : _ -> connectsL cityA firstEnlace && connectsL cityB (last enlaces)

usesT :: Link -> Tunel -> Bool -- indica si este tunel atraviesa ese link
usesT enlace (Tun enlaces) = enlace `elem` enlaces

-- la demora que sufre una conexion en este tunel
delayT :: Tunel -> Float
delayT (Tun enlaces) = sum $ map delayL enlaces
