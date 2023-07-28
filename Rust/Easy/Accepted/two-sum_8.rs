impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        
        let mut res: Vec<i32> = vec![];
        let mut i = 0;
        while i < nums.len() {
            let mut j = 0;
            while j < nums.len() {
                if i != j {
                    if nums[i] + nums[j] == target {
                        res.push(i as i32);
                        res.push(j as i32);
                        return res;
                    }
                }
                j += 1;
            }
            i += 1;
        }
        res
    }
}