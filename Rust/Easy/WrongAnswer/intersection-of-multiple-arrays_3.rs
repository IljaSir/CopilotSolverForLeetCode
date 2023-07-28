impl Solution {
    pub fn intersection(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut a = nums[0].clone();
        for i in 1..nums.len() {
            let mut b = Vec::new();
            for j in 0..nums[i].len() {
                if a.contains(&nums[i][j]) {
                    b.push(nums[i][j]);
                }
            }
            a = b;
        }
        a
    }
}