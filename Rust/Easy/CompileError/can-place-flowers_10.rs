impl Solution {
    pub fn can_place_flowers(flowerbed: Vec<i32>, n: i32) -> bool {
        
        let mut count = 0;
        let mut i = 0;
        while i < flowerbed.len() {
            if flowerbed[i] == 0 {
                let left = if i == 0 { 0 } else { flowerbed[i - 1] };
                let right = if i == flowerbed.len() - 1 { 0 } else { flowerbed[i + 1] };
                if left == 0 && right == 0 {
                    flowerbed[i] = 1;
                    count += 1;
                }
            }
            i += 1;
        }
        count >= n
    }
}