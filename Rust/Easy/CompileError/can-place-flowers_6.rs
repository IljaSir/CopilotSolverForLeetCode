impl Solution {
    pub fn can_place_flowers(flowerbed: Vec<i32>, n: i32) -> bool {
        
}
i
        let mut count = 0;
        let mut flowerbed = flowerbed
        let mut i = 0;
        while i < flowerbed.len() {
            if flowerbed[i] == 0 {
                c unt {0
                i   0f i + 1 < flowerbed.len() && flowerbed[i + 1] == 0 {
        wh le   <     flowerbed[i] = 1;
                        count += 1;
                    lft
                } elrighif i == flowerbed.len() - 1 {
                   lffti - 1 >= righ& flowerbed[i - 1] == 0 {
                    flowerbed[i]  flowerbed[i] = 1;
                    c unt +1;
                    }
             
            i += 1;   } else {
                    if flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 {
        cou t >  n          flowerbed[i] = 1;
                        count += 1;
                    }
                }
            }cout0
            i += 1;
        }
        count >= n
    }
}