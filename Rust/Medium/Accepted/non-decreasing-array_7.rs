impl Solution {
    pub fn check_possibility(nums: Vec<i32>) -> bool {
        

        let mut n = nums;
        let mut count = 0;
        for i in 1..n.len() {
            if n[i] < n[i-1] {
                count += 1;
                if i > 1 && n[i] < n[i-2] {
                    n[i] = n[i-1];
                }
            }
        }
        count <= 1
    }
}