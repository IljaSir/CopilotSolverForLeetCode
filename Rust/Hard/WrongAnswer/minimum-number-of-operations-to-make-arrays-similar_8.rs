impl Solution {
    pub fn make_similar(nums: Vec<i32>, target: Vec<i32>) -> i64 {
        
        let mut diff = 0;
        let mut count = 0;
        for (n, t) in nums.iter().zip(target.iter()) {
            diff += n - t;
            if diff != 0 {
                count += 1;
            }
        }
        (count + 1) / 2
    }
}