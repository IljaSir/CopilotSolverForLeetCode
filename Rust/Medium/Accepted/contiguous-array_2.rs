impl Solution {
    pub fn find_max_length(nums: Vec<i32>) -> i32 {
        

        let mut ans = 0;
        let mut sum = 0;
        let mut map = std::collections::HashMap::new();
        for i in 0..nums.len() {
            sum += if nums[i] == 1 { 1 } else { -1 };
            if sum == 0 {
                ans = i + 1;
            } else {
                if let Some(&last) = map.get(&sum) {
                    ans = ans.max(i - last);
                } else {
                    map.insert(sum, i);
                }
            }
        }
        ans as i32
    }
}