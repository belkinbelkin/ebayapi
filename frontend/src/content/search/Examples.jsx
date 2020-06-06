import React from "react";

export default function Examples({visible, examples}) {
    if (!visible) return null;
    else return <div className={'example-container'}>
        { (examples || []).slice(0, 14).map(example => <img key={example} className={'example-image'}
                                                            src={example} alt={'N/A'}/>) }
    </div>
}