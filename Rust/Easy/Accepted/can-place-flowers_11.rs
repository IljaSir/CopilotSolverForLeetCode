impl Solution {
    pub fn can_place_flowers(flowerbed: Vec<i32>, n: i32) -> bool {
        
        let mut flowerbed = flowerbed;
        let mut n = n;
        for i in 0..flowerbed.len() {
            if flowerbed[i] == 0 {
                let mut prev = false;
                let mut next = false;
                if i == 0 {
                    prev = true;
                } else {
                    prev = flowerbed[i-1] == 0;
                }
                if i == flowerbed.len() - 1 {
                    next = true;
                } else {
                    next = flowerbed[i+1] == 0;
                }
                if prev && next {
                    flowerbed[i] = 1;
                    n -= 1;
                }
            }
        }
        n <= 0
    }
}