impl Solution {
    pub fn garbage_collection(garbage: Vec<String>, travel: Vec<i32>) -> i32 {
        
        let mut metal = 0;
        let mut paper = 0;
        let mut glass = 0;
        for item in garbage {
            for ch in item.chars() {
                match ch {
                    'M' => metal += 1,
                    'P' => paper += 1,
                    'G' => glass += 1,
                    _ => (),
                }
            }
        }
        let mut time = paper * travel[0];
        let mut index = 0;
        for i in 1..garbage.len() {
            let mut tmp = 0;
            for ch in garbage[i].chars() {
                match ch {
                    'P' => tmp += 1,
                    _ => (),
                }
            }
            if tmp > 0 {
                time += tmp * travel[i];
                index = i;
                break;
            }
        }
        for i in (index + 1)..garbage.len() {
            let mut tmp = 0;
            for ch in garbage[i].chars() {
                match ch {
                    'G' => tmp += 1,
                    _ => (),
                }
            }
            if tmp > 0 {
                time += tmp * travel[i];
                break;
            }
        }
        time
    }
}