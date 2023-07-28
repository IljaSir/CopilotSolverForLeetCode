impl Solution {
    pub fn special_array(nums: Vec<i32>) -> i32 {
        
        let mut count = vec![0; 1001];
        for num in nums.iter() {
            count[*num as usize] += 1;
        }
        for i in 0..1001 {
            let mut s = 0;
            for j in i..1001 {
                s += count[j];
            }
            if s == i {
                return i as i32;
            }
        }
        -1
    }
}