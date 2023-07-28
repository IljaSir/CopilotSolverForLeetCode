impl Solution {
    pub fn total_fruit(fruits: Vec<i32>) -> i32 {
        
        let mut count = vec![0; fruits.len()];
        let mut max = 0;
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        while j < fruits.len() {
            if count[fruits[j] as usize] == 0 {
                k += 1;
            }
            count[fruits[j] as usize] += 1;
            while k > 2 {
                count[fruits[i] as usize] -= 1;
                if count[fruits[i] as usize] == 0 {
                    k -= 1;
                }
                i += 1;
            }
            max = max.max(j - i + 1);
            j += 1;
        }
        max as i32
    }
}