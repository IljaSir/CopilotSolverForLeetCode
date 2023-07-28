impl Solution {
    pub fn intersection(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut result: Vec<i32> = Vec::new();
        for i in 0..nums[0].len() {
            let mut flag = true;
            for j in 1..nums.len() {
                if !nums[j].contains(&nums[0][i]) {
                    flag = false;
                    break;
                }
            }
            if flag {
                result.push(nums[0][i]);
            }
        }
        result
    }
}