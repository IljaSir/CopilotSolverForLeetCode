impl Solution {
    pub fn digit_count(num: String) -> bool {
        
        let mut arr = [0; 10];
        for c in num.chars() {
            arr[c as usize - '0' as usize] += 1;
        }
        for i in 0..10 {
            if arr[i] != 0 && arr[i] != i {
                return false;
            }
        }
        return true;
    }
}