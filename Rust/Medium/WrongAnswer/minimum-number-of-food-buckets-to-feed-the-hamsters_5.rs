impl Solution {
    pub fn minimum_buckets(hamsters: String) -> i32 {
        
        let mut count = 0;
        let mut previous = false;
        for c in hamsters.chars() {
            if c == 'H' {
                if previous {
                    count += 1;
                    previous = false;
                } else {
                    previous = true;
                }
            } else {
                previous = false;
            }
        }
        if previous {
            count += 1;
        }
        count
    }
}