impl Solution {
    pub fn pivot_array(nums: Vec<i32>, pivot: i32) -> Vec<i32> {
        
        let mut less = vec![];
        let mut equal = vec![];
        let mut greater = vec![];
        for n in nums {
            if n < pivot {
                less.push(n);
            } else if n > pivot {
                greater.push(n);
            } else {
                equal.push(n);
            }
        }
        let mut result = vec![];
        result.append(&mut less);
        result.append(&mut equal);
        result.append(&mut greater);
        result
    }
}