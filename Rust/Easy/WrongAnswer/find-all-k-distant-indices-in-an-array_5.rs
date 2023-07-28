impl Solution {
    pub fn find_k_distant_indices(nums: Vec<i32>, key: i32, k: i32) -> Vec<i32> {
        
        let mut ans = Vec::new();
        for i in 0..nums.len() {
            for j in i..nums.len() {
                if (j as i32 - i as i32) > k {
                    break;
                }
                if nums[j] == key {
                    ans.push(i as i32);
                    break;
                }
            }
        }
        ans
    }
}