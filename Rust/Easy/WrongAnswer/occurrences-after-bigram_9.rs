impl Solution {
    pub fn find_ocurrences(text: String, first: String, second: String) -> Vec<String> {
        
        let mut ret = vec![];
        let mut words = text.split(' ');
        let mut first = first.as_str();
        let mut second = second.as_str();
        let mut third = words.next();
        while let Some(t) = third {
            if first == t {
                if let Some(t) = words.next() {
                    if second == t {
                        if let Some(t) = words.next() {
                            ret.push(t.to_string());
                        }
                    } else {
                        second = t;
                    }
                }
            } else {
                first = t;
            }
            third = words.next();
        }
        ret
    }
}