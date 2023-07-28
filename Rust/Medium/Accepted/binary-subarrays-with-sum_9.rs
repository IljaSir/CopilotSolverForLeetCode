impl Solution {
    pub fn num_subarrays_with_sum(nums: Vec<i32>, goal: i32) -> i32 {
        
        let mut res = 0;
        let mut sum = 0;
        let mut cnt = std::collections::HashMap::new();
        for n in nums {
            cnt.entry(sum).and_modify(|x| *x += 1).or_insert(1);
            sum += n;
            res += *cnt.get(&(sum - goal)).unwrap_or(&0);
        }
        res
    }
}