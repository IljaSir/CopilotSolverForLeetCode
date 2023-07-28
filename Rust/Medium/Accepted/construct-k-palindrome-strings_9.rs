impl Solution {
    pub fn can_construct(s: String, k: i32) -> bool {
        
        let len = s.len();
        let k = k as usize;
        if k > len {
            return false;
        }
        let mut count = [0; 26];
        for c in s.chars() {
            count[c as usize - 'a' as usize] += 1;
        }
        let odd_count = count.iter().filter(|&x| *x % 2 == 1).count();
        odd_count <= k
    }
}