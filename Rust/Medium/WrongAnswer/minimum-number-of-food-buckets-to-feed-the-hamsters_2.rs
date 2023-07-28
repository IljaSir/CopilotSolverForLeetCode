impl Solution {
    pub fn minimum_buckets(hamsters: String) -> i32 {
        
        let mut count = 0;
        let mut has_hamster = false;
        for c in hamsters.chars() {
            if c == 'H' {
                if !has_hamster {
                    has_hamster = true;
                } else {
                    count += 1;
                }
            } else {
                has_hamster = false;
            }
        }
        if count > 0 {
            count + 1
        } else {
            -1
        }
    }
}