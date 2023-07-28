impl Solution {
    pub fn count_smaller(nums: Vec<i32>) -> Vec<i32> {
        
        let mut counts = vec![0; nums.len()];
        let mut sorted = vec![];
        for (i, &n) in nums.iter().rev().enumerate() {
            let pos = sorted.binary_search(&n).unwrap_or_else(|x| x);
            counts[nums.len() - 1 - i] = pos as i32;
            sorted.insert(pos, n);
        }
        counts
    }
}