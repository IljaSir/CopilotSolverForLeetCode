impl Solution {
    pub fn find_k_distant_indices(nums: Vec<i32>, key: i32, k: i32) -> Vec<i32> {
        
        let mut ans = Vec::new();
        let mut indices = Vec::new();
        for (i, &num) in nums.iter().enumerate() {
            if num == key {
                indices.push(i as i32);
            }
        }
        for i in 0..nums.len() {
            let mut flag = false;
            for &j in indices.iter() {
                if (i as i32 - j).abs() <= k {
                    flag = true;
                    break;
                }
            }
            if flag {
                ans.push(i as i32);
            }
        }
        ans
    }
}