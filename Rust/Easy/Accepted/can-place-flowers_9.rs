impl Solution {
    pub fn can_place_flowers(flowerbed: Vec<i32>, n: i32) -> bool {
        
        let mut n = n;
        let mut flowerbed = flowerbed;
        let mut i = 0;
        while i < flowerbed.len() {
            if flowerbed[i] == 0 {
                if i == 0 || flowerbed[i - 1] == 0 {
                    if i == flowerbed.len() - 1 || flowerbed[i + 1] == 0 {
                        n -= 1;
                        flowerbed[i] = 1;
                    }
                }
            }
            i += 1;
        }
        n <= 0
    }
}