module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Point
import City  
import Quality
import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT enlace = Tun [enlace]

--connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
--connectsL ciudad (Lin ciudad1 ciudad2 _) = ciudad == ciudad1 || ciudad == ciudad2

connectsT :: City -> City -> Tunel -> Bool  -- indica si este tunel conecta estas dos ciudades distintas
connectsT ciudad1 ciudad2 (Tun enlaces) =
    case enlaces of
        [] -> False
        links ->
            let connectedPairs = zip links (tail links)
                isConnected (Lin c1 c2 _) (Lin c2' _ _) = c2 == c2'
            in any (\(link1, link2) -> isConnected link1 link2 &&
                                      (connectsL ciudad1 link1 || connectsL ciudad2 link1) &&
                                      (connectsL ciudad1 link2 || connectsL ciudad2 link2))
                   connectedPairs

--connectsT ciudad1 ciudad2 (Tun enlaces) =
--    let connectedPairs = zip enlaces (tail enlaces)
--        isConnected (_, c2, _) (_, c2', _) = c2 == c2'
--    in any (\((_, c1, _), (_, c2, _)) -> isConnected c1 c2 &&
--                                      (connectsL ciudad1 c1 || connectsL ciudad2 c1) &&
--                                      (connectsL ciudad1 c2 || connectsL ciudad2 c2))
--           connectedPairs

--Tunel tiene una lista de varios links, si conecta dos ciudades distintas solo importan las ciudades de las puntas.
--Cuando se crea el tunel hay que verificar que anda. Ej: a->b,b->c,c->d.

usesT :: Link -> Tunel -> Bool -- indica si este tunel atraviesa ese link
usesT enlace (Tun enlaces) = enlace `elem` enlaces

-- la demora que sufre una conexion en este tunel
delayT :: Tunel -> Float
delayT (Tun enlaces) = sum [delayQ quality | (Lin _ _ quality) <- enlaces]

--delayT (Tun enlaces) = sum [delayQ quality | (_, _, quality) <- enlaces]
