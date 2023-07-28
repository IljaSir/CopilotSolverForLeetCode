impl Solution {
    pub fn find_closest_number(nums: Vec<i32>) -> i32 {
        
        let mut closest = 0;
        let mut distance = i32::MAX;
        for &num in nums.iter() {
            let d = num.abs();
            if d < distance || (d == distance && num > closest) {
                closest = num;
                distance = d;
            }
        }
        closest
    }
}