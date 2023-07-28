impl Solution {
    pub fn reorganize_string(s: String) -> String {
        
        let mut counter = std::collections::HashMap::new();
        for c in s.chars() {
            *counter.entry(c).or_insert(0) += 1;
        }
        let mut heap = std::collections::BinaryHeap::new();
        for (c, cnt) in counter.into_iter() {
            heap.push((cnt, c));
        }
        let mut ret = String::new();
        while heap.len() > 1 {
            let (cnt1, c1) = heap.pop().unwrap();
            let (cnt2, c2) = heap.pop().unwrap();
            ret.push(c1);
            ret.push(c2);
            if cnt1 > 1 {
                heap.push((cnt1 - 1, c1));
            }
            if cnt2 > 1 {
                heap.push((cnt2 - 1, c2));
            }
        }
        if heap.len() > 0 {
            let (cnt, c) = heap.pop().unwrap();
            if cnt > 1 {
                return String::new();
            }
            ret.push(c);
        }
        ret
    }
}