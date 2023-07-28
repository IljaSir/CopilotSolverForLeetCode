impl Solution {
    pub fn min_cost(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut cost = 0;
        let mut count = vec![0; nums.len()];
        for n in nums.iter() {
            count[*n as usize] += 1;
        }
        let mut single = vec![];
        for i in 0..count.len() {
            if count[i] == 1 {
                single.push(i as i32);
            }
        }
        let mut result = 0;
        for i in 0..nums.len() {
            if single.contains(&nums[i]) {
                result += 1;
            }
            if i > 0 && nums[i] != nums[i - 1] {
                if single.contains(&nums[i - 1]) {
                    result -= 1;
                }
            }
            if i == nums.len() - 1 || nums[i] != nums[i + 1] {
                cost += std::cmp::min(result, k);
                result = 0;
            }
        }
        cost
    }
}