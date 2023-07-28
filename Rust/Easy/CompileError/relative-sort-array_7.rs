impl Solution {
    pub fn relative_sort_array(arr1: Vec<i32>, arr2: Vec<i32>) -> Vec<i32> {
        
        let mut map = std::collections::HashMap::new();
        for i in arr2 {
            map.insert(i, 0);
        }
        let mut v = vec![];
        let mut w = vec![];
        for i in arr1 {
            if let Some(x) = map.get_mut(&i) {
                *x += 1;
            } else {
                w.push(i);
            }
        }
        for i in arr2 {
            v.append(&mut vec![i; map[&i] as usize]);
        }
        w.sort();
        v.append(&mut w);
        v
    }
}