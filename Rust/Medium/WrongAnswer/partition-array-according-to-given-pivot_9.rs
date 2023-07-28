impl Solution {
    pub fn pivot_array(nums: Vec<i32>, pivot: i32) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut mid = Vec::new();
        for num in nums {
            if num < pivot {
                res.push(num);
            } else if num > pivot {
                mid.push(num);
            } else {
                res.push(num);
            }
        }
        res.append(&mut mid);
        res
    }
}