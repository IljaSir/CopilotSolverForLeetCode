impl Solution {
    pub fn find_max_length(nums: Vec<i32>) -> i32 {
        

        let mut map = std::collections::HashMap::new();
        let mut sum = 0;
        let mut ans = 0;
        for (i, &n) in nums.iter().enumerate() {
            if n == 1 {
                sum += 1;
            } else {
                sum -= 1;
            }
            if sum == 0 {
                ans = i + 1;
            }
            if let Some(&j) = map.get(&sum) {
                ans = ans.max(i - j);
            } else {
                map.insert(sum, i);
            }
        }
        ans as i32
    }
}