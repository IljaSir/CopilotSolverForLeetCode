impl Solution {
    pub fn count_smaller(nums: Vec<i32>) -> Vec<i32> {
        
        let mut ret = vec![0; nums.len()];
        let mut sorted = Vec::new();
        for (i, &num) in nums.iter().rev().enumerate() {
            let pos = sorted.binary_search(&num).unwrap_or_else(|x| x);
            ret[nums.len() - 1 - i] = pos as i32;
            sorted.insert(pos, num);
        }
        ret
    }
}