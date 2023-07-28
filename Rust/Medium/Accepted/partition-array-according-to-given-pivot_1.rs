impl Solution {
    pub fn pivot_array(nums: Vec<i32>, pivot: i32) -> Vec<i32> {
        
        let mut less = Vec::new();
        let mut equal = Vec::new();
        let mut greater = Vec::new();
        for n in nums {
            if n < pivot {
                less.push(n);
            } else if n == pivot {
                equal.push(n);
            } else {
                greater.push(n);
            }
        }
        let mut result = Vec::new();
        result.append(&mut less);
        result.append(&mut equal);
        result.append(&mut greater);
        return result;
    }
}