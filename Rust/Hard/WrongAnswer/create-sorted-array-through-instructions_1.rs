impl Solution {
    pub fn create_sorted_array(instructions: Vec<i32>) -> i32 {
        
        let mut nums = vec![];
        let mut cost = 0;
        for i in instructions {
            let left = nums.binary_search(&i).unwrap_or_else(|x| x);
            let right = nums.len() - left;
            cost += std::cmp::min(left, right) as i32;
            nums.insert(left, i);
        }
        cost % 1_000_000_007
    }
}