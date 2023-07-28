impl Solution {
    pub fn maximum_time(time: String) -> String {
        
        let mut result = String::new();
        let mut time_iter = time.chars();
        match time_iter.next().unwrap() {
            '2' => {
                result.push('2');
                match time_iter.next().unwrap() {
                    '?' => result.push('3'),
                    c => result.push(c),
                }
            }
            '1' | '0' => {
                match time_iter.next().unwrap() {
                    '?' => result.push('9'),
                    c => result.push(c),
                }
            }
            '?' => {
                match time_iter.next().unwrap() {
                    '?' | '0' | '1' | '2' | '3' => {
                        result.push('2');
                        result.push('3');
                    }
                    _ => {
                        result.push('1');
                        result.push('9');
                    }
                }
            }
            _ => unreachable!(),
        }
        result.push(':');
        match time_iter.next().unwrap() {
            '?' => result.push('5'),
            c => result.push(c),
        }
        match time_iter.next().unwrap() {
            '?' => result.push('9'),
            c => result.push(c),
        }
        result
    }
}