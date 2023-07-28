impl Solution {
    pub fn can_place_flowers(flowerbed: Vec<i32>, n: i32) -> bool {
        
        let mut n = n;
        let mut flowerbed = flowerbed;
        let mut i = 0;
        while i < flowerbed.len() {
            if flowerbed[i] == 0 {
                let mut can = true;
                if i > 0 {
                    if flowerbed[i-1] == 1 {
                        can = false;
                    }
                }
                if i < flowerbed.len() - 1 {
                    if flowerbed[i+1] == 1 {
                        can = false;
                    }
                }
                if can {
                    flowerbed[i] = 1;
                    n -= 1;
                    if n == 0 {
                        return true;
                    }
                }
            }
            i += 1;
        }
        n == 0
    }
}