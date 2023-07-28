impl Solution {
    pub fn total_fruit(fruits: Vec<i32>) -> i32 {
        
        let mut baskets = vec![0; fruits.len()];
        let mut count = 0;
        let mut max = 0;
        for i in 0..fruits.len() {
            if baskets[fruits[i] as usize] == 0 {
                count += 1;
            }
            baskets[fruits[i] as usize] += 1;
            while count > 2 {
                baskets[fruits[i - max] as usize] -= 1;
                if baskets[fruits[i - max] as usize] == 0 {
                    count -= 1;
                }
                max -= 1;
            }
            max += 1;
        }
        max as i32
    }
}