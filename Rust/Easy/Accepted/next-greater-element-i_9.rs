impl Solution {
    pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        
        let mut res = Vec::new();
        for &num1 in nums1.iter() {
            let mut found = false;
            let mut greater = -1;
            for &num2 in nums2.iter() {
                if num2 == num1 {
                    found = true;
                }
                if found && num2 > num1 {
                    greater = num2;
                    break;
                }
            }
            res.push(greater);
        }
        res
    }
}