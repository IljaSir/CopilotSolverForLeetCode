impl Solution {
    pub fn can_be_increasing(nums: Vec<i32>) -> bool {
        
        let mut a = nums.clone();
        if a.windows(2).all(|x| x[0] < x[1]) {
            return true;
        }
        for i in 0..a.len() {
            let mut b = a.clone();
            b.remove(i);
            if b.windows(2).all(|x| x[0] < x[1]) {
                return true;
            }
        }
        false
    }
}