module Point ( Point, newP, difP)
   where

data Point = Poi Int Int deriving (Eq, Show)

newP :: Int -> Int -> Point
newP a b = Poi a b 

difP :: Point -> Point -> Float  -- distancia absoluta
difP (Poi a1 b1) (Poi a2 b2) = sqrt (fromIntegral((a2 - a1)^2 + (b2 - b1)^2))
