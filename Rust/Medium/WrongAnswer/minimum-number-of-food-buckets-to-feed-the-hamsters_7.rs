impl Solution {
    pub fn minimum_buckets(hamsters: String) -> i32 {
        
        let mut res = 0;
        let mut i = 0;
        let mut j = hamsters.len() - 1;
        let mut left = false;
        let mut right = false;
        while i < j {
            if hamsters.as_bytes()[i] == 'H' as u8 {
                if left {
                    res += 1;
                    left = false;
                }
                if right {
                    right = false;
                }
            } else {
                if !left {
                    left = true;
                }
            }
            if hamsters.as_bytes()[j] == 'H' as u8 {
                if right {
                    res += 1;
                    right = false;
                }
                if left {
                    left = false;
                }
            } else {
                if !right {
                    right = true;
                }
            }
            i += 1;
            j -= 1;
        }
        if i == j && hamsters.as_bytes()[i] == '.' as u8 {
            if left || right {
                res += 1;
            }
        }
        res
    }
}