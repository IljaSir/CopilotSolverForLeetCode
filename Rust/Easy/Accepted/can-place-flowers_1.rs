impl Solution {
    pub fn can_place_flowers(flowerbed: Vec<i32>, n: i32) -> bool {
        
        let mut count = 0;
        let mut flowerbed = flowerbed;
        flowerbed.insert(0, 0);
        flowerbed.push(0);
        for i in 1..flowerbed.len() - 1 {
            if flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0 {
                count += 1;
                flowerbed[i] = 1;
            }
        }
        count >= n
    }
}