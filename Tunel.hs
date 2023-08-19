module Tunel ( Tunel, newT, usesT, delayT)--, connectsT)
   where

import Point
import City  
import Quality
import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT enlaces = Tun enlaces

--connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
--connectsL ciudad (Lin ciudad1 ciudad2 _) = ciudad == ciudad1 || ciudad == ciudad2

--connectsT :: City -> City -> Tunel -> Bool  -- indica si este tunel conecta estas dos ciudades distintas
--connectsT ciudad1 ciudad2 (Tun enlaces) =

--Usar funciones de Link no el constructor Lin.
--Tunel tiene una lista de varios links, si conecta dos ciudades distintas solo importan las ciudades de las puntas.
--Cuando se crea el tunel hay que verificar que anda. Ej: a->b,b->c,c->d.

usesT :: Link -> Tunel -> Bool -- indica si este tunel atraviesa ese link
usesT enlace (Tun enlaces) = enlace `elem` enlaces

-- la demora que sufre una conexion en este tunel
delayT :: Tunel -> Float
delayT (Tun enlaces) = sum $ map delayL enlaces
