import Quality
import Point
import City
import Link
import Tunel
import Region

bue = newC "Buenos Aires" (newP 1 1)
par = newC "Paris" (newP 2 2)
lon = newC "Londres" (newP 2 1)
rom = newC "Roma" (newP 1 2)
tok = newC "Tokio" (newP 3 2)
syd = newC "Sydney" (newP 2 3)

calidad1 = newQ "buena" 4 3.0
calidad2 = newQ "mala" 3 2.0

link1 = newL rom lon calidad2
link2 = newL par tok calidad1
link3 = newL lon bue calidad1

tunel1 = newT [link1, link3, link2]
tunel2 = newT [link3, link1, link2]
tunel3 = newT [link1]
tunel4 = newT []

regionInicial = newR

test = [capacityQ calidad1 == 4,                    --TRUE
        delayQ calidad1 == 3.0,                     --TRUE
        difP (newP 1 1) (newP 2 2) == 1.4142135,    --TRUE
        nameC bue == "Buenos Aires",                --TRUE
        distanceC bue par == 1.4142135,             --TRUE
        connectsL lon link1 == True, --TRUE
        connectsL bue link1 == True,   --FALSE
        linksL bue par link2 == True, ---FALSE
        capacityL link1 == 3, --TRUE
        delayL link1 == 2.0, --TRUE
        usesT link1 tunel1 == True, --TRUE
        delayT tunel1 == 5.0, --FALSE
        connectsT rom tok tunel1 == True, --TRUE
        connectsT rom bue tunel1 == False, --TRUE
        connectsT rom bue tunel4 == False, --TRUE
        connectsT rom lon tunel3 == True] --TRUE
        --tunelR regionInicial [rom, lon, tok] == 
