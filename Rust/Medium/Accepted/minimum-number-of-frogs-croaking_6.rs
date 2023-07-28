impl Solution {
    pub fn min_number_of_frogs(croak_of_frogs: String) -> i32 {
        
        let mut count = [0; 5];
        let mut frogs = 0;
        let mut max = 0;
        for c in croak_of_frogs.chars() {
            let i = match c {
                'c' => 0,
                'r' => 1,
                'o' => 2,
                'a' => 3,
                'k' => 4,
                _ => return -1,
            };
            if i == 0 {
                frogs += 1;
            }
            if frogs == 0 {
                return -1;
            }
            count[i] += 1;
            if i > 0 && count[i] > count[i - 1] {
                return -1;
            }
            if i == 4 {
                frogs -= 1;
            }
            max = max.max(frogs);
        }
        if frogs > 0 {
            return -1;
        }
        max
    }
}