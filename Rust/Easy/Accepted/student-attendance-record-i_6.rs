impl Solution {
    pub fn check_record(s: String) -> bool {
        
        let mut absent = 0;
        let mut late = 0;
        for c in s.chars() {
            match c {
                'L' => {
                    late += 1;
                    if late > 2 {
                        return false;
                    }
                },
                'A' => {
                    absent += 1;
                    if absent > 1 {
                        return false;
                    }
                    late = 0;
                },
                _ => {
                    late = 0;
                }
            }
        }
        true
    }
}