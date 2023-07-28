impl Solution {
    pub fn halves_are_alike(s: String) -> bool {
        
        let mut count = 0;
        let mut a = s.chars().take(s.len() / 2);
        let mut b = s.chars().skip(s.len() / 2);
        for _ in 0..s.len() / 2 {
            if "aeiouAEIOU".contains(a.next().unwrap()) {
                count += 1;
            }
            if "aeiouAEIOU".contains(b.next().unwrap()) {
                count -= 1;
            }
        }
        count == 0
    }
}