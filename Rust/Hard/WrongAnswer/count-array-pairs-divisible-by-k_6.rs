impl Solution {
    pub fn count_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut count = 0;
        let mut map = vec![0; k as usize];
        for num in nums {
            let remainder = num % k;
            if remainder == 0 {
                count += map[0];
            } else {
                count += map[(k - remainder) as usize];
            }
            map[remainder as usize] += 1;
        }
        count
    }
}