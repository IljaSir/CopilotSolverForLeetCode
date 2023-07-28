impl Solution {
    pub fn max_total_fruits(fruits: Vec<Vec<i32>>, start_pos: i32, k: i32) -> i32 {
        
        let mut result = 0;
        let mut left = 0;
        let mut right = 0;
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        let n = fruits.len();
        while right < n && left <= right {
            while right < n && (right - left) as i32 <= k {
                let pos = fruits[right][0];
                let amount = fruits[right][1];
                let c = map.entry(pos).or_insert(0);
                *c += amount;
                if *c == amount {
                    count += 1;
                }
                right += 1;
            }
            if count <= 2 {
                result = result.max(fruits[left..right].iter().map(|x| x[1]).sum());
            }
            while left < right && count > 2 {
                let pos = fruits[left][0];
                let amount = fruits[left][1];
                let c = map.entry(pos).or_insert(0);
                *c -= amount;
                if *c == 0 {
                    count -= 1;
                }
                left += 1;
            }
        }
        result
    }
}